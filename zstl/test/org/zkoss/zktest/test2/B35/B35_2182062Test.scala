/* B35_2182062Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 16, 2012 15:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2182062.zul,B,E,Window,Button")
class B35_2182062Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <window>
        The two inner tabbox should not have scroll button
        <tabbox width="400px" height="200px">
          <tabs>
            <tab label="Tab 1 test long text"/>
            <tab label="Tab 2 test long text"/>
            <tab label="Tab 2 test long text"/>
            <tab label="Tab 2 test long text"/>
            <tab label="Tab 2 test long text"/>
            <tab label="Tab 3 test long text"/>
            <tab label="Tab 4 test long text"/>
          </tabs>
          <tabpanels>
            <tabpanel>
              <tabbox width="200px">
                <tabs>
                  <tab label="Tab 1"/>
                  <tab label="Tab 2"/>
                </tabs>
                <tabpanels>
                  <tabpanel>
                    This is panel
                            1
                  </tabpanel>
                  <tabpanel>
                    This is panel 2 The
                            second panel
                  </tabpanel>
                </tabpanels>
              </tabbox>
              <tabbox width="200px" tabscroll="false">
                <tabs>
                  <tab label="Tab 1"/>
                  <tab label="Tab 2"/>
                </tabs>
                <tabpanels>
                  <tabpanel>
                    This is panel
                            1
                  </tabpanel>
                  <tabpanel>
                    This is panel 2 The
                            second panel
                  </tabpanel>
                </tabpanels>
              </tabbox>
            </tabpanel>
            <tabpanel>
              This is panel 2 The second panel
            </tabpanel>
            <tabpanel>
              This is panel 3
            </tabpanel>
            <tabpanel>
              This is panel 4
            </tabpanel>
          </tabpanels>
        </tabbox>
      </window>
    """;
    runZTL(zscript, () => {
      // Verify that there is only one right scroll button (the outer tabbox)
      verifyTrue("There should be only one scrolled tabbox", jq(jq("@tabbox").toWidget().$n("right")).length() == 1);

      // Verify that there is only one left scroll button (the outer tabbox)
      verifyTrue("There should be only one scrolled tabbox", jq(jq("@tabbox").toWidget().$n("left")).length() == 1);

    })
  }
}