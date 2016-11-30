/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.metamodel.call.impl;

import org.antlr.v4.runtime.tree.ParseTree;

import io.proleap.vb6.parser.metamodel.EnumerationConstant;
import io.proleap.vb6.parser.metamodel.Module;
import io.proleap.vb6.parser.metamodel.Scope;
import io.proleap.vb6.parser.metamodel.call.EnumerationConstantCall;
import io.proleap.vb6.parser.metamodel.type.Type;

public class EnumerationConstantCallImpl extends CallImpl implements EnumerationConstantCall {

	protected EnumerationConstant enumerationConstant;

	protected boolean standalone;

	public EnumerationConstantCallImpl(final String name, final EnumerationConstant enumerationConstant,
			final Module module, final Scope scope, final ParseTree ctx) {
		super(name, module, scope, ctx);

		this.enumerationConstant = enumerationConstant;
	}

	@Override
	public CallType getCallType() {
		return CallType.EnumerationConstantCall;
	}

	@Override
	public EnumerationConstant getEnumerationConstant() {
		return enumerationConstant;
	}

	@Override
	public Type getType() {
		final Type result;

		if (enumerationConstant != null) {
			result = enumerationConstant.getType();
		} else {
			result = null;
		}

		return result;
	}

	@Override
	public boolean isStandaloneCall() {
		return standalone;
	}

	@Override
	public void setStandaloneCall(final boolean standalone) {
		this.standalone = standalone;
	}

	@Override
	public String toString() {
		return super.toString() + ", enumerationConstant=[" + enumerationConstant + "]";
	}
}