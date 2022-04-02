package com.gk.streamapi.exceptionHandling;

@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<Target, ExObj extends Exception> {

	public void accept(Target target) throws ExObj;

}
