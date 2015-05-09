/*
 * MozView Technologies, Lda. 2010 - 2015
 */

package mz.co.mozview.frameworks.core.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Stélio Moiane
 *
 */
@Aspect
@Component
public class CleanDBAspect {
	private final Logger logger = Logger.getLogger(CleanDBAspect.class);

	@Before("daoMethods()")
	public void starttingLog(final JoinPoint joinPoint) {

		final String methodName = joinPoint.getSignature().getName();
		final String typeName = joinPoint.getSignature().getDeclaringTypeName();

		this.logger.info("A executar o método: " + methodName + " da classe " + typeName);
	}

	@Pointcut("execution(* mz.co.mozview.frameworks.core.dao.*.create(Long, *))")
	public void daoMethods() {
	}

	@AfterReturning(pointcut = "daoMethods()", returning = "returnObject")
	public void resultLog(final JoinPoint joinPoint, final Object returnObject) {

		final String methodName = joinPoint.getSignature().getName();
		final String typeName = joinPoint.getSignature().getDeclaringTypeName();

		final String name = joinPoint.getArgs()[1].getClass().getName();
		CleanDBUtil.pushEntity(name);

		this.logger.info("O resultado do método: " + methodName + " da classe " + typeName + " é " + returnObject);
		this.logger.info("A lista contem: " + CleanDBUtil.entitiesCreated.size() + " tabela(s)");
	}
}
