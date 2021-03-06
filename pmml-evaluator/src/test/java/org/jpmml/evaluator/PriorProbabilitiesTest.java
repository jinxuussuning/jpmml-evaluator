/*
 * Copyright (c) 2013 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator;

import java.util.List;
import java.util.Map;

import org.dmg.pmml.DataType;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.Target;
import org.dmg.pmml.TargetValue;
import org.dmg.pmml.Targets;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriorProbabilitiesTest extends ModelEvaluatorTest {

	@Test
	public void evaluate() throws Exception {
		ModelEvaluator<?> evaluator = createModelEvaluator();

		ModelEvaluationContext context = evaluator.createContext(null);

		Map<FieldName, ? extends Classification> predictions = TargetUtil.evaluateClassificationDefault(context);

		assertEquals(1, predictions.size());

		ProbabilityDistribution response = (ProbabilityDistribution)predictions.get(evaluator.getTargetField());

		assertEquals((Double)0.02d, response.getProbability("YES"));
		assertEquals((Double)0.98d, response.getProbability("NO"));

		Map<FieldName, ?> result = OutputUtil.evaluate(predictions, context);

		FieldName field = new FieldName("I_response");
		FieldName displayField = new FieldName("U_response");

		assertEquals("NO", result.get(field));
		assertEquals("No", result.get(displayField));

		assertEquals(DataType.STRING, OutputUtil.getDataType(evaluator.getOutputField(field), evaluator));
		assertEquals(DataType.STRING, OutputUtil.getDataType(evaluator.getOutputField(displayField), evaluator));

		assertEquals(0.02d, result.get(new FieldName("P_responseYes")));
		assertEquals(0.98d, result.get(new FieldName("P_responseNo")));
	}

	@Test
	public void evaluateEmptyTarget() throws Exception {
		ModelEvaluator<?> evaluator = createModelEvaluator();

		Targets targets = evaluator.getTargets();
		for(Target target : targets){
			List<TargetValue> targetValues = target.getTargetValues();

			targetValues.clear();
		}

		ModelEvaluationContext context = evaluator.createContext(null);

		Map<FieldName, ? extends Classification> predictions = TargetUtil.evaluateClassificationDefault(context);

		assertEquals(1, predictions.size());

		Classification response = predictions.get(evaluator.getTargetField());

		assertEquals(null, response);
	}
}