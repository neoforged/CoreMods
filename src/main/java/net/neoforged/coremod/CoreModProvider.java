package net.neoforged.coremod;

import cpw.mods.modlauncher.api.*;
import net.neoforged.neoforgespi.coremod.*;

import java.util.*;

public class CoreModProvider implements ICoreModProvider {
    private CoreModEngine engine = new CoreModEngine();
    @Override
    public void addCoreMod(final ICoreModFile file) {
        engine.loadCoreMod(file);
    }

    @Override
    public List<ITransformer<?>> getCoreModTransformers() {
        return engine.initializeCoreMods();
    }
}
