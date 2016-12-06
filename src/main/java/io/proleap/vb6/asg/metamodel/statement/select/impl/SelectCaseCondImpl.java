/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.statement.select.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.vb6.VisualBasic6Parser.SC_CondContext;
import io.proleap.vb6.asg.metamodel.Module;
import io.proleap.vb6.asg.metamodel.Scope;
import io.proleap.vb6.asg.metamodel.impl.ScopedElementImpl;
import io.proleap.vb6.asg.metamodel.statement.select.SelectCase;
import io.proleap.vb6.asg.metamodel.statement.select.SelectCaseCond;
import io.proleap.vb6.asg.metamodel.type.Type;
import io.proleap.vb6.asg.metamodel.valuestmt.ValueStmt;

public class SelectCaseCondImpl extends ScopedElementImpl implements SelectCaseCond {

	protected final SC_CondContext ctx;

	protected SelectCase selectCase;

	protected final SelectCaseCondType selectCaseCondType;

	protected final List<ValueStmt> valueStmts = new ArrayList<ValueStmt>();

	public SelectCaseCondImpl(final SelectCaseCondType selectCaseCondType, final Module module,
			final Scope scope, final SC_CondContext ctx) {
		super(module, scope, ctx);

		this.ctx = ctx;
		this.selectCaseCondType = selectCaseCondType;
	}

	@Override
	public void addValueStmt(final ValueStmt valueStmt) {
		valueStmts.add(valueStmt);
	}

	@Override
	public SC_CondContext getCtx() {
		return ctx;
	}

	@Override
	public SelectCase getSelectCase() {
		return selectCase;
	}

	@Override
	public SelectCaseCondType getSelectCaseCondType() {
		return selectCaseCondType;
	}

	@Override
	public Type getType() {
		final Type result;

		if (SelectCaseCondType.ELSE.equals(selectCaseCondType)) {
			result = null;
		} else if (!valueStmts.isEmpty()) {
			result = valueStmts.get(0).getType();
		} else {
			result = null;
		}

		return result;
	}

	@Override
	public List<ValueStmt> getValueStmts() {
		return valueStmts;
	}

	@Override
	public void setSelectCase(final SelectCase selectCase) {
		this.selectCase = selectCase;
	}
}