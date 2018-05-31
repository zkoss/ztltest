package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2509.zul")
class B70_ZK_2509Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<zk>
    <custom-attributes org.zkoss.zul.nativebar="true"/>
    <label multiline="true">
    1. scroll to right most.
    2. scroll back to left.
    3. you should not see the column with tiny width 
    </label>
    <zscript><![CDATA[
    Object[] columns = new Object[50];
    ]]></zscript>
    <grid width="500px">
        <frozen columns="1" />
        <columns>
            <column label="2200" align="center" hflex="min" forEach="${columns}" />
        </columns>
        <rows>
            <row forEach="1,2,3,4,5,6">
                <label value="5" forEach="${columns}" />
            </row>
        </rows>
    </grid>
</zk>

"""
    runZTL(zscript,
      () => {
        val grid = jq(".z-grid")
        var width = jq(jq(".z-column").get(2)).width();
        nativeFrozenScroll(grid, 2860);
        waitResponse();
        nativeFrozenScroll(grid, -2860);
        verifyTrue(jq(jq(".z-column").get(2)).width() == width);

      })

  }
}