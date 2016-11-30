/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.metamodel.impl;

import org.antlr.v4.runtime.tree.ParseTree;

import io.proleap.vb6.parser.metamodel.LineLabel;
import io.proleap.vb6.parser.metamodel.Module;
import io.proleap.vb6.parser.metamodel.OnError;
import io.proleap.vb6.parser.metamodel.Scope;

public class OnErrorImpl extends ScopedElementImpl implements OnError {

	protected LineLabel lineLabel;

	public OnErrorImpl(final LineLabel lineLabel, final Module module, final Scope scope, final ParseTree ctx) {
		super(module, scope, ctx);

		this.lineLabel = lineLabel;
	}

	@Override
	public LineLabel getLineLabel() {
		return lineLabel;
	}

	@Override
	public String toString() {
		return "lineLabel=[" + lineLabel + "]";
	}
}