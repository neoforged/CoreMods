package net.neoforged.coremod.transformer;

import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.TargetType;
import net.neoforged.coremod.CoreMod;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.MethodNode;

import java.util.Set;
import java.util.function.Function;

public class CoreModMethodTransformer extends CoreModBaseTransformer<MethodNode> implements ITransformer<MethodNode> {
    public CoreModMethodTransformer(CoreMod coreMod, String coreName, Set<Target<MethodNode>> targets, Function<MethodNode, MethodNode> function) {
        super(coreMod, coreName, targets, function);
    }

    @Override
    public @NotNull TargetType<MethodNode> getTargetType() {
        return TargetType.METHOD;
    }

    @Override
    MethodNode runCoremod(MethodNode input) {
        LOGGER.debug(COREMOD, "Transforming {} with desc {}", input.name, input.desc);
        return function.apply(input);
    }
}
