package org.javasimon.jmx;

import java.beans.ConstructorProperties;

/**
 * Value object for retrieving data from Counter simon. Basically, it's
 * {@link org.javasimon.CounterSample} with added JMX capabilities to be return as object via
 * MXBean method.
 * <p>
 * Example:
 * <pre>
 * SimonMXBean simon = JMX.newMXBeanProxy(..., new ObjectName("domain:type=Simon"), SimonMXBean.class);
 * CounterSample = simon.getCounterSample("simon.counter");
 * </pre>
 *
 * @author Radovan Sninsky
 * @version $Revision$ $Date$
 * @created 23.1.2009 12:37:40
 * @since 2
 */
public final class CounterSample extends org.javasimon.CounterSample {

	/**
	 * JMX constructor. Constructor used by JMX client code to initialize all properties of object
	 * from composite data object. 
	 *
	 * @param count count value (provided optionally)
	 * @param mean mean value (provided optionally)
	 * @param stdDev standard deviation (provided optionally)
	 * @param sum sum value (provided optionally)
	 * @param var variance (provided optionally)
	 * @param varN variance N (provided optionally)
	 * @param note note (provided optionally)
	 * @param counter actual counter value
	 * @param min minimal counter value
	 * @param max maximal counter value
	 * @param minTimestamp time when counter reached minimal value
	 * @param maxTimestamp time when counter reached maximal value
	 * @param incSum sum of all increments
	 * @param decSum sum of all decrements
	 */
	@ConstructorProperties({"count", "mean", "standardDeviation", "sum", "variance", "varianceN", "note", "counter", "min", "max", "minTimestamp",
		"maxTimestamp", "incrementSum", "decrementSum"})
	public CounterSample(int count, double mean, double stdDev, double sum, double var, double varN, String note,
		long counter, long min, long max, long minTimestamp, long maxTimestamp, long incSum, long decSum) {
		setCount(count);
		setMean(mean);
		setStandardDeviation(stdDev);
		setSum(sum);
		setVariance(var);
		setVarianceN(varN);
		setNote(note);

		setCounter(counter);
		setMin(min);
		setMax(max);
		setMinTimestamp(minTimestamp);
		setMaxTimestamp(maxTimestamp);
		setIncrementSum(incSum);
		setDecrementSum(decSum);
	}

	/**
	 * Internall, framework constructor for Simon MBean implementation to initialize all properties
	 * by sample obtained from simon.
	 *
	 * @param s sample object obtained from Counter simon
	 */
	CounterSample(org.javasimon.CounterSample s) {
		setCount(s.getCount());
		setMean(s.getMean());
		setStandardDeviation(s.getStandardDeviation());
		setSum(s.getSum());
		setVariance(s.getVariance());
		setVarianceN(s.getVarianceN());
		setNote(s.getNote());

		setCounter(s.getCounter());
		setMin(s.getMin());
		setMax(s.getMax());
		setMinTimestamp(s.getMinTimestamp());
		setMaxTimestamp(s.getMaxTimestamp());
		setIncrementSum(s.getIncrementSum());
		setDecrementSum(s.getDecrementSum());
	}
}