package net.neoforged.coremod.transformer;

import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.TargetType;
import net.neoforged.coremod.CoreMod;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.FieldNode;

import java.util.Set;
import java.util.function.Function;

public class CoreModFieldTransformer extends CoreModBaseTransformer<FieldNode> implements ITransformer<FieldNode> {
    public CoreModFieldTransformer(CoreMod coreMod, String coreName, Set<Target<FieldNode>> targets, Function<FieldNode, FieldNode> function) {
        super(coreMod, coreName, targets, function);
    }

    @Override
    public @NotNull TargetType<FieldNode> getTargetType() {
        return TargetType.FIELD;
    }

    @Override
    FieldNode runCoremod(FieldNode input) {
        LOGGER.debug(COREMOD, "Transforming {} with desc {}", input.name, input.desc);
        return function.apply(input);
    }
}
