/* Z30_grid_0006Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 11:54:15 CST 2011 , Created by TonyQ
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug grid-0005
  *
  * @author TonyQ
  *
  */
@Tags(tags = "Z30-grid-0005.zul,Z30,grid,column,auxhead,colspan,sizable,ie9")
class Z30_grid_0005Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>Test the complex grid with Auxhead, you can see the layout shows properly and also shows properly after sizing the header.</n:p>
			<window title="Test common grid and auxhead.">
			  <checkbox id="checkbox" label="sizable" onCheck="head3.sizable = self.checked"/>
				<grid id="grid">
					<auxhead id="head1">
						<auxheader label="A+B" colspan="2"/>
						<auxheader label="C"/>
					</auxhead>	
					<auxhead id="head2">
						<auxheader label="A"/>
						<auxheader label="B+C"  colspan="2"/>
					</auxhead>
					<columns id="head3">
						<column id="column" label="AA"/>
						<column label="BB"/>
						<column label="CC"/>
					</columns>
					<auxhead id="head4">
						<auxheader label="A+B+C" colspan="3"/>
					</auxhead>
					<rows>
						<row>
							<label value="AA01"/>
							<label value="BB01"/>
							<label value="CC01"/>
						</row>
						<row>
							<label value="AA01"/>
							<label value="BB01"/>
							<label value="CC01"/>
						</row>
						<row>
							<label value="AA01"/>
							<label value="BB01"/>
							<label value="CC01"/>
						</row>
					</rows>
				</grid>
			</window>
		</zk>
    """;

    runZTL(zscript,
      () => {
        var checkId = jq("$checkbox").toWidget().uuid() + "-real";
        var $jq = jq("$column");
        var uuid = jq("$column").toWidget().uuid();
        var $head = jq("$grid").toWidget().$n("head");
        var $body = jq("$grid").toWidget().$n("body");
        // check colSpan
        var c1 = parseInt(jq("$head1").toWidget().firstChild().$n().attr("colSpan"));
        var c2 = parseInt(jq("$head2").toWidget().lastChild().$n().attr("colSpan"));
        verifyEquals(4, c1 + c2);
        c1 = parseInt(jq("$head2").toWidget().firstChild().$n().attr("colSpan"));
        c2 = parseInt(jq("$head2").toWidget().lastChild().$n().attr("colSpan"));
        verifyEquals(3, c1 + c2);
        c1 = parseInt(jq("$head3").toWidget().firstChild().$n().attr("colSpan"));
        c2 = parseInt(jq("$head3").toWidget().firstChild().nextSibling().$n().attr("colSpan"));
        var c3 = parseInt(jq("$head3").toWidget().lastChild().$n().attr("colSpan"));
        verifyEquals(3, c1 + c2 + c3);
        c1 = parseInt(jq("$head4").toWidget().firstChild().$n().attr("colSpan"));
        verifyEquals(3, c1);
        var w = jq("$grid").innerWidth()
        verifyEquals(w + "", jq($head).outerWidth());
        verifyEquals(w + "", jq($body).outerWidth());
        var h = jq("$grid").height();
        verifyEquals(h, parseInt($head.attr("offsetHeight")) + parseInt($body.attr("offsetHeight")));
        // check sizing
        click(checkId);
        waitResponse();
        var width = getElementWidth(uuid);
        mouseMoveAt($jq.toWidget(), width + ",0");
        waitResponse()
        verifyTrue($jq.hasClass("z-column-sizing"));
        //a workaround to chrome, move 10px per drag
        dragdropTo(jq("$column").toWidget(), width + ",0", width.intValue() - 10 + ",0");
        dragdropTo(jq("$column").toWidget(), width.intValue() - 10 + ",0", width.intValue() - 20 + ",0");
        verifyNotEquals(width.intValue(), getElementWidth(uuid).intValue());
      }
    );
  }
}