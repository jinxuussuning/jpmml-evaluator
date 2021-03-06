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
package org.jpmml.rattle;

import java.util.Set;

import com.google.common.collect.Sets;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.Batch;
import org.jpmml.evaluator.BatchUtil;
import org.jpmml.evaluator.NodeScoreDistribution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClassificationTest {

	@Test
	public void evaluateDecisionTreeIris() throws Exception {
		Batch batch = new RattleBatch("DecisionTree", "Iris");

		NodeScoreDistribution targetValue = (NodeScoreDistribution)BatchUtil.evaluateDefault(batch);

		assertEquals("7", targetValue.getEntityId());

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateGeneralRegressionIris() throws Exception {
		Batch batch = new RattleBatch("GeneralRegression", "Iris");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateKernlabSVMIris() throws Exception {
		Batch batch = new RattleBatch("KernlabSVM", "Iris");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateLibSVMIris() throws Exception {
		Batch batch = new RattleBatch("LibSVM", "Iris");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateLogisticRegressionIris() throws Exception {
		Batch batch = new RattleBatch("LogisticRegression", "Iris");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateNaiveBayesIris() throws Exception {
		Batch batch = new RattleBatch("NaiveBayes", "Iris");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateNeuralNetworkIris() throws Exception {
		Batch batch = new RattleBatch("NeuralNetwork", "Iris");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateRandomForestIris() throws Exception {
		Batch batch = new RattleBatch("RandomForest", "Iris");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateRegressionIris() throws Exception {
		Batch batch = new RattleBatch("Regression", "Iris");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateDecisionTreeAudit() throws Exception {
		Batch batch = new RattleBatch("DecisionTree", "Audit");

		NodeScoreDistribution targetValue = (NodeScoreDistribution)BatchUtil.evaluateDefault(batch);

		assertEquals("2", targetValue.getEntityId());

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateGeneralRegressionAudit() throws Exception {
		Batch batch = new RattleBatch("GeneralRegression", "Audit");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateKernlabSVMAudit() throws Exception {
		Batch batch = new RattleBatch("KernlabSVM", "Audit");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateLibSVMAudit() throws Exception {
		Batch batch = new RattleBatch("LibSVM", "Audit");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateLogisticRegressionAudit() throws Exception {
		Batch batch = new RattleBatch("LogisticRegression", "Audit");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateNaiveBayesAudit() throws Exception {
		Batch batch = new RattleBatch("NaiveBayes", "Audit");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateNeuralNetworkAudit() throws Exception {
		Batch batch = new RattleBatch("NeuralNetwork", "Audit");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		Set<FieldName> ignoredFields = Sets.newHashSet(new FieldName("Probability_0"), new FieldName("Probability_1"));

		assertTrue(BatchUtil.evaluate(batch, ignoredFields));
	}

	@Test
	public void evaluateRandomForestAudit() throws Exception {
		Batch batch = new RattleBatch("RandomForest", "Audit");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateRegressionAudit() throws Exception {
		Batch batch = new RattleBatch("Regression", "Audit");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		assertTrue(BatchUtil.evaluate(batch));
	}
}