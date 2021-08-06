package com.example.aopDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.aopDemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//using pointcut declaration
	
	    // creating pointcut declaration for AccountDao
		@Pointcut("execution(* com.example.aopDemo.dao.AccountDao.*(..))")
		public void forAccountDao() {}

//		//creating pointcut declaration for MembershipDao
//		@Pointcut("execution(* com.example.aopDemo.dao.MembershipDao.*(..))")
//		public void forMembershipDao() {}
//		
//		// @Before advice
//		// Below Pointcut expression match any addAccount() method in 
//		// any class in com.example.aopDemo.dao package
//		
//		@Before("forAccountDao()")
//		public void beforeAddAccountAdvice() {
//			
//			System.out.println("\n====>>> Executing @Before advice on addAccount()");
//		}
//		
//		// Below Pointcut expression match any method starting with "add" 
//		// and having any number of arguments of any type and present in 
//		// any class in com.example.aopDemo.dao package 
//		@Before("forMembershipDao()")
//		public void beforeAnyMembershipDaoMethod()
//		{
//			System.out.println("\n====>>> Executing @Before advice on any method with any number of arguments and starting with add \n");
//		}

		
		// combining pointcuts
		
		//creating pointcut declaration for getter() methods
		@Pointcut("execution(* com.example.aopDemo.dao.AccountDao.get*(..))")
		private void getter() {}
		
		
		//creating pointcut declaration for setter() methods
		@Pointcut("execution(* com.example.aopDemo.dao.AccountDao.set*(..))")
		private void setter() {}
		
		//combine pointcut: include AccountDao class methods and exclude getter & setter methods
		@Pointcut("forAccountDao() && !(getter() || setter())")
		private void forAccountDaoExceptGetterSetter() {}
		
		
		//Creating a JoinPoint to get the information about the method that is executing
		@Before("forAccountDaoExceptGetterSetter()")
		public void beforeAccountDaoNotIncludeGetterSetter(JoinPoint theJoinPoint) {
			
			System.out.println("\n AccountDao methods except Getters and Setters");
			
			//display the method signature
			MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
			System.out.println("Method being executing :" + methodSig );
			
			//display method arguments
			
			//get the arguments
			Object[] args = theJoinPoint.getArgs();
			
			//loop through the arguments
			for(Object temp : args) {
				System.out.println(temp);
			
//			if(temp instanceof Account)
//			{
//				Account theAccount = (Account) temp;
//				
//				System.out.println("account name:" + theAccount.getName());
//				System.out.println("account level:" + theAccount.getLevel());
//			}
		}
	}
		


		

}
