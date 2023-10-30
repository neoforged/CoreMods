package net.neoforged.coremod;

import java.util.function.Function;

import javax.script.Bindings;
import javax.script.ScriptEngine;

import org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.openjdk.nashorn.api.scripting.ScriptObjectMirror;

class NashornFactory {
    private static final String[] ARGS = new String[] {"--language=es6"};
    static ScriptEngine createEngine() {
        return new NashornScriptEngineFactory().getScriptEngine(ARGS, getAppClassLoader(), CoreModEngine::checkClass);
    }

    private static ClassLoader getAppClassLoader() {
        final ClassLoader ccl = Thread.currentThread().getContextClassLoader();
        return (ccl == null) ? NashornScriptEngineFactory.class.getClassLoader() : ccl;
    }

    @SuppressWarnings("unchecked")
    static <A,R> Function<A,R> getFunction(Bindings obj) {
        return a -> (R)((ScriptObjectMirror)obj).call(obj, a);
    }
}
