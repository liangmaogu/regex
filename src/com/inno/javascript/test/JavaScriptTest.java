package com.inno.javascript.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptTest {
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("js");
		
		String script = "var a = 'hello script';print(a); document.getElementById('hello');";
		engine.eval(script);
	}
}
