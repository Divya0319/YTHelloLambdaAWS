package com.fastturtle.YtHelloLambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloLambdaTest {
	
	@Test
	public void shouldReturnHelloMessage() {
		HelloLambda sut = new HelloLambda();
		Assertions.assertEquals("Hello, AWS Lambda!!", sut.handleRequest());
	}

	

}
