/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import org.jooq.Clause;
import org.jooq.Configuration;
import org.jooq.Context;
import org.jooq.QueryPart;
import org.jooq.QueryPartInternal;
import org.jooq.SQL;
import org.jooq.impl.QOM.UEmpty;
import org.jooq.impl.QOM.UEmptyQuery;

/**
 * @author Lukas Eder
 */
final class SQLQuery extends AbstractRowCountQuery implements UEmptyQuery {

    private final SQL delegate;

    SQLQuery(Configuration configuration, SQL delegate) {
        super(configuration);

        this.delegate = delegate;
    }

    // ------------------------------------------------------------------------
    // Query API
    // ------------------------------------------------------------------------

    @Override
    public final void accept(Context<?> ctx) {
        switch (ctx.family()) {






            default:
                ctx.visit(delegate);
                break;
        }
    }

    @Override
    public final Clause[] clauses(Context<?> ctx) {
        if (delegate instanceof QueryPartInternal q)
            return q.clauses(ctx);

        return null;
    }
}
