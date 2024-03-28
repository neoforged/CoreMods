package net.neoforged.coremod;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

class JSFileLoader implements ICoreModScriptSource {
    private final Path path;

    JSFileLoader(final String path) {
        this.path = FileSystems.getDefault().getPath(path);
    }

    @Override
    public Reader readCoreMod() {
        try {
            return Files.newBufferedReader(this.path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reader getAdditionalFile(final String fileName) throws IOException {
        return Files.newBufferedReader(this.path.getParent().resolve(fileName));
    }

    @Override
    public String getOwnerId() {
        return "dummy";
    }

    @Override
    public String getDebugSource() {
        return path.toString();
    }
}
