/*
 * Copyright (c) NeoForged and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */
package net.neoforged.coremod;

import java.io.IOException;
import java.io.Reader;

/**
 * Interface for core mods to discover content and properties
 * of their location and context to the coremod implementation.
 */
public interface ICoreModScriptSource {
    String getOwnerId();
    Reader readCoreMod() throws IOException;
    Reader getAdditionalFile(final String fileName) throws IOException;
    String getDebugSource();
}
