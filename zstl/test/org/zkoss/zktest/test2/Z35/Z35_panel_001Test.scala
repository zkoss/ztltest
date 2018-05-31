/* Z35_panel_001Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 12:42:36 CST 2011 , Created by TonyQ
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug panel-001
  *
  * @author TonyQ
  *
  */
@Tags(tags = "Z35-panel-001.zul,Z35,A,E,Panel")
class Z35_panel_001Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<window>
			<panel id="p1" width="500px">
				<panelchildren>
					Change view: Click following buttons and it should work well.
				</panelchildren>
			</panel>
					<button id="btn1" label="Change title">
						<attribute name="onClick">
							if(p1.title=="")
								p1.setTitle("Panel Component");
							else
								p1.setTitle("");
						</attribute>
					</button>
					<button id="btn2" label="Change border">
						<attribute name="onClick">
							if(p1.border=="none")
								p1.setBorder("normal");
							else
								p1.setBorder("none");
						</attribute>
					</button>
					<button id="btn3" label="Change framable">
						<attribute name="onClick">
								p1.framable=!p1.framable;
						</attribute>
					</button>
					<button id="btn4" label="Change width and height">
						<attribute name="onClick">
							if(p1.width.equals("500px")) {
								p1.setWidth("700px");
								p1.setHeight("300px");
							} else {
								p1.setWidth("500px");
								p1.setHeight("150px");
							}
						</attribute>
					</button>
			</window>

    """;

    runZTL(zscript,
      () => {

        verifyEquals(jq(".z-panel-header").length, 0);
        click(jq("$btn1"));
        waitResponse();

        verifyEquals(jq(".z-panel-header").length, 1);
        verifyEquals(jq(".z-panel-header").text(), "Panel Component");


        verifyEquals(jq(".z-panelchildren").length, 1);
        click(jq("$btn2"));
        waitResponse();
        verifyFalse(jq(".z-panel").hasClass(".z-panel-noborder"));

        click(jq("$btn3"));
        waitResponse();
        verifyFalse(jq(".z-panel").hasClass(".z-panel-noframe"));

        val width = jq(".z-panel").outerWidth()
        click(jq("$btn4"));
        waitResponse();
        verifyNotEquals(width, jq(".z-panel").outerWidth())

      }
    );
  }
}