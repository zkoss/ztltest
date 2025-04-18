/* B30_1828044Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 1828044
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B30-1828044.zul,A,E,Grid,Column")
class B30_1828044Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<window>
			When the header is invisible, the whole column should be disappeared.
			
				<grid>
					<columns id="cols">
						<column id="col1" label="Column1" width="20%"
							visible="false" />
						<column id="col2" label="Column2" width="80%" />
					</columns>
					<rows>
						<row>
							<label value="Row1" />
							<label value="Row2" />
						</row>
			
					</rows>
				</grid>
				<button label="visible"
					onClick='col1.visible = !col1.visible; col2.visible = !col2.visible;' />
				<button label="cols visible"
					onClick='cols.visible = !cols.visible;' />
			</window>

   """
    runZTL(zscript,
      () => {
        click(jq("@button:eq(0)"));
        waitResponse();
        //col1 must be visible & col2 invisible
        var faker1 = jq(jq("$col1").toWidget().$n("hdfaker")).attr("style")
        var faker2 = jq(jq("$col2").toWidget().$n("hdfaker")).attr("style")
        verifyNotContains(faker1, "collapse")
        verifyContains(faker2, "collapse")

        click(jq("@button:eq(0)"))
        waitResponse()
        faker1 = jq(jq("$col1").toWidget().$n("hdfaker")).attr("style")
        faker2 = jq(jq("$col2").toWidget().$n("hdfaker")).attr("style")
        //col1 must be invisible & col2 visible
        verifyNotContains(faker2, "collapse")
        verifyContains(faker1, "collapse")

        click(jq("@button:eq(1)"))
        waitResponse()
        //Header must be invisible & cols too
        verifyFalse(jq("$cols").isVisible())

        click(jq("@button:eq(1)"))
        waitResponse()
        //Cols must be visible
        verifyTrue(jq("$cols").isVisible())

      }
    );
  }
}
