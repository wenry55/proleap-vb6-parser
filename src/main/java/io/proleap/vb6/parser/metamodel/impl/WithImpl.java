/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.metamodel.impl;

import io.proleap.vb6.VisualBasic6Parser.WithStmtContext;
import io.proleap.vb6.parser.metamodel.Module;
import io.proleap.vb6.parser.metamodel.Scope;
import io.proleap.vb6.parser.metamodel.With;
import io.proleap.vb6.parser.metamodel.call.Call;

public class WithImpl extends ScopeImpl implements With {

	protected final WithStmtContext ctx;

	protected Call withVariableCall;

	public WithImpl(final Module module, final Scope scope, final WithStmtContext ctx) {
		super(module, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public WithStmtContext getCtx() {
		return ctx;
	}

	@Override
	public Call getWithVariableCall() {
		return withVariableCall;
	}

	@Override
	public void setWithVariableCall(final Call withVariableCall) {
		this.withVariableCall = withVariableCall;
	}

}