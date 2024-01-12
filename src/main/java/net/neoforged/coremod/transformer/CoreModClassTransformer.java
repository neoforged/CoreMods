package net.neoforged.coremod.transformer;

import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.TargetType;
import net.neoforged.coremod.CoreMod;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.ClassNode;

import java.util.Set;
import java.util.function.Function;

public class CoreModClassTransformer extends CoreModBaseTransformer<ClassNode> implements ITransformer<ClassNode> {
    public CoreModClassTransformer(CoreMod coreMod, String coreName, Set<Target<ClassNode>> targets, Function<ClassNode, ClassNode> function) {
        super(coreMod, coreName, targets, function);
    }

    @Override
    ClassNode runCoremod(ClassNode input) {
        LOGGER.debug(COREMOD, "Transforming {}", input.name);
        return function.apply(input);
    }

    @Override
    public @NotNull TargetType<ClassNode> getTargetType() {
        return TargetType.CLASS;
    }
}
