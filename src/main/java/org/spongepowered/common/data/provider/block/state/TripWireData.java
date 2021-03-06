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
package org.spongepowered.common.data.provider.block.state;

import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.api.data.Keys;
import org.spongepowered.common.data.provider.DataProviderRegistrator;
import org.spongepowered.common.util.DirectionalUtil;

public final class TripWireData {

    private TripWireData() {
    }

    // @formatter:off
    public static void register(final DataProviderRegistrator registrator) {
        registrator
                .asImmutable(BlockState.class)
                    .create(Keys.CONNECTED_DIRECTIONS)
                        .get(h -> DirectionalUtil.getHorizontalFrom(h, TripWireBlock.EAST, TripWireBlock.WEST, TripWireBlock.NORTH,
                                TripWireBlock.SOUTH))
                        .set((h, v) -> DirectionalUtil.setHorizontal(h, v, TripWireBlock.EAST, TripWireBlock.WEST, TripWireBlock.NORTH,
                                TripWireBlock.SOUTH))
                        .supports(h -> h.getBlock() instanceof TripWireBlock)
                    .create(Keys.IS_ATTACHED)
                        .get(h -> h.getValue(TripWireBlock.ATTACHED))
                        .set((h, v) -> h.setValue(TripWireBlock.ATTACHED, v))
                        .supports(h -> h.getBlock() instanceof TripWireBlock)
                    .create(Keys.IS_DISARMED)
                        .get(h -> h.getValue(TripWireBlock.DISARMED))
                        .set((h, v) -> h.setValue(TripWireBlock.DISARMED, v))
                        .supports(h -> h.getBlock() instanceof TripWireBlock)
                    .create(Keys.IS_POWERED)
                        .get(h -> h.getValue(TripWireBlock.POWERED))
                        .set((h, v) -> h.setValue(TripWireBlock.POWERED, v))
                        .supports(h -> h.getBlock() instanceof TripWireBlock)
                    .create(Keys.IS_CONNECTED_EAST)
                        .get(h -> h.getValue(TripWireBlock.EAST))
                        .set((h, v) -> h.setValue(TripWireBlock.EAST, v))
                        .supports(h -> h.getBlock() instanceof TripWireBlock)
                    .create(Keys.IS_CONNECTED_NORTH)
                        .get(h -> h.getValue(TripWireBlock.NORTH))
                        .set((h, v) -> h.setValue(TripWireBlock.NORTH, v))
                        .supports(h -> h.getBlock() instanceof TripWireBlock)
                    .create(Keys.IS_CONNECTED_SOUTH)
                        .get(h -> h.getValue(TripWireBlock.SOUTH))
                        .set((h, v) -> h.setValue(TripWireBlock.SOUTH, v))
                        .supports(h -> h.getBlock() instanceof TripWireBlock)
                    .create(Keys.IS_CONNECTED_WEST)
                        .get(h -> h.getValue(TripWireBlock.WEST))
                        .set((h, v) -> h.setValue(TripWireBlock.WEST, v))
                        .supports(h -> h.getBlock() instanceof TripWireBlock);
    }
    // @formatter:on
}
