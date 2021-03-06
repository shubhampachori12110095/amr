/*******************************************************************************
 * UW SPF - The University of Washington Semantic Parsing Framework
 * <p>
 * Copyright (C) 2013 Yoav Artzi
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 ******************************************************************************/
package edu.uw.cs.lil.amr;

import java.io.File;
import java.io.IOException;

import edu.cornell.cs.nlp.spf.mr.lambda.ccg.LogicalExpressionCategoryServices;
import edu.cornell.cs.nlp.utils.log.LogLevel;
import edu.cornell.cs.nlp.utils.log.Logger;

public class TestServices {

	private static final LogicalExpressionCategoryServices	CATEGORY_SERVICES;

	private static final File								DEFAULT_TYPES_FILE;

	private TestServices() {
		// Private ctor. Nothing to init. Service class.
	}

	static {
		LogLevel.DEBUG.set();
		Logger.setSkipPrefix(true);

		DEFAULT_TYPES_FILE = new File("../resources/amr.types");

		try {
			Init.init(
					DEFAULT_TYPES_FILE,
					new File("../resources/amr.specmap"),
					new File(
							"../resources/stanford-models/english-bidirectional-distsim.tagger"),
					false, null, null, null, false);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}

		// //////////////////////////////////////////////////
		// Category services for logical expressions.
		// //////////////////////////////////////////////////

		// CCG LogicalExpression category services for handling categories
		// with LogicalExpression as semantics
		CATEGORY_SERVICES = new LogicalExpressionCategoryServices(true);

	}

	public static LogicalExpressionCategoryServices getCategoryServices() {
		init();
		return CATEGORY_SERVICES;
	}

	public static void init() {
		// Nothing to do.
	}
}
