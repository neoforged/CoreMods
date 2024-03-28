/*
 * Copyright (c) NeoForged and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */
package net.neoforged.coremod;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;

/**
 * Interface for core mods to discover content and properties
 * of their location and context to the coremod implementation.
 */
public interface ICoreModFile {
    String getOwnerId();
    Reader readCoreMod() throws IOException;
    Path getPath();
    Reader getAdditionalFile(final String fileName) throws IOException;
}