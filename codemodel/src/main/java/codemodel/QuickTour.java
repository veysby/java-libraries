package codemodel;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.writer.SingleStreamCodeWriter;

public class QuickTour {

	public static void main(String[] args) throws Exception {
		JCodeModel jmodel = new JCodeModel();
		JPackage pack = jmodel._package("test.codemodel.cli");
		JDefinedClass cl = pack._class("HelloWorld");
		
		JMethod m = cl.method(JMod.PUBLIC | JMod.STATIC, jmodel.VOID, "main");
		m.param(jmodel.parseType("String[]"), "args");
		m._throws(Exception.class);
		
		JBlock b = m.body();
		
		JInvocation i = b.invoke(jmodel.ref(System.class).staticRef("out"), "println");
		i.arg("Hello, World!");
		
		jmodel.build(new SingleStreamCodeWriter( System.out ));
	}

}
