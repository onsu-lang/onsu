/**
 * 
 * BSD 3-Clause License
 *
 * Copyright (c) 2021, onsu-lang Timo Sarkar
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * @author Timo Sarkar
 * @version 0.0.1-dev
 */

package org.onsu-lang.onsu.typesystem;

import org.onsu-lang.jvm.JvmType;
import org.onsu-lang.onsu.symbols.Symbol;

import java.util.Map;
import java.util.Optional;

public interface TypeUsage {
    /**
     * Relation with other type-objects 
     */
    default boolean isArray() {
        return false;
    }

    default boolean isPrimitive() {
        return false;
    }

    /**
     * Reference to an object, class or enum
     */
    default boolean isReferenceTypeUsage() {
        return false;
    }

    default boolean isVoid() {
        return false;
    }

    default boolean isTypeVariable() {
        return false;
    }

    default ReferenceTypeUsage asReferenceTypeUsage() {
        throw new UnsupportedOperationException(this.getClass().getCanonicalName());
    }

    default ArrayTypeUsage asArrayTypeUsage() {
        throw new UnsupportedOperationException();
    }

    default PrimitiveTypeUsage asPrimitiveTypeUsage() {
        throw new UnsupportedOperationException();
    }

    default TypeVariableUsage asTypeVariableUsage() {
        throw new UnsupportedOperationException();
    }

    default boolean isReference() {
        return false;
    }

    default boolean isInvokable() {
        return false;
    }

    default Invokable asInvokable() {
        throw new UnsupportedOperationException(this.getClass().getCanonicalName() + ": " + this);
    }

    /**
     * Begin of jvm part
     * define the corresponding jvm types
     * beginning the part with our fiels
     */
    default boolean hasInstanceField(String fieldName, Symbol instance) {
        throw new UnsupportedOperationException(this.getClass().getCanonicalName());
    }

    default Symbol getInstanceField(String fieldName, Symbol instance) {
        throw new UnsupportedOperationException(this.getClass().getCanonicalName());
    }

    /**
     * Begin of jvm part
     * defining the corresponding jvm types
     * beginning the part with methods
     */
    default Optional<Invokable> getMethod(String method, boolean staticContext) {
        throw new UnsupportedOperationException(this.getClass().getCanonicalName());
    }

    /**
     * Begin of jvm part
     * defining the corresponding jvm types
     * beginnin the part with misc stuff
     */
    boolean sameType(TypeUsage other);
    boolean canBeAssignedTo(TypeUsage type);

    <T extends TypeUsage> TypeUsage replaceTypeVariables(Map<String, T> typeParams);

    default String describe() {
        throw new UnsupportedOperationException(this.getClass().getCanonicalName());
    }
}
