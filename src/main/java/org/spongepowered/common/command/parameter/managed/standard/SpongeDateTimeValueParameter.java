/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.common.command.parameter.managed.standard;

import com.google.common.collect.ImmutableList;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.exception.ArgumentParseException;
import org.spongepowered.api.command.parameter.ArgumentReader;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.common.command.brigadier.argument.ResourceKeyedArgumentValueParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class SpongeDateTimeValueParameter extends ResourceKeyedArgumentValueParser<LocalDateTime> {

    public SpongeDateTimeValueParameter(final ResourceKey key) {
        super(key);
    }

    @Override
    @NonNull
    public List<String> complete(@NonNull final CommandCause context, final @NonNull String currentInput) {
        return Collections.emptyList();
    }

    @Override
    @NonNull
    public Optional<? extends LocalDateTime> getValue(
            final @NonNull CommandCause cause, final ArgumentReader.@NonNull Mutable reader) throws ArgumentParseException {
        final String date = reader.parseString();
        try {
            return Optional.of(LocalDateTime.parse(date));
        } catch (final DateTimeParseException ex) {
            try {
                return Optional.of(LocalDateTime.of(LocalDate.now(), LocalTime.parse(date)));
            } catch (final DateTimeParseException ex2) {
                try {
                    return Optional.of(LocalDateTime.of(LocalDate.parse(date), LocalTime.MIDNIGHT));
                } catch (final DateTimeParseException ex3) {
                    throw reader.createException(Component.text("Invalid date-time!"));
                }
            }
        }
    }
}
