
package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1441.zul")
class B65_ZK_1441Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <label multiline="true">
                      1. Click "Tab 8" to open it.
	2. Click "Tab 7"~"Tab 2" very quickly(miss click one or more Tab is ok.) then Click "Tab 1" (still quickly).
	3. The content and height of "Tab 1" must correctly.
                    </label>
                    <tabbox mold="accordion">
                      <tabs>
                        <tab label="Tab 1"/>
                        <tab label="Tab 2"/>
                        <tab label="Tab 3"/>
                        <tab label="Tab 4"/>
                        <tab label="Tab 5"/>
                        <tab label="Tab 6"/>
                        <tab label="Tab 7"/>
                        <tab label="Tab 8"/>
                      </tabs>
                      <tabpanels>
                        <tabpanel>
                          <tabbox orient="vertical">
                            <tabs width="20px">
                              <tab label="A"/>
                              <tab label="B"/>
                              <tab label="C"/>
                              <tab label="D"/>
                              <tab label="E"/>
                            </tabs>
                            <tabpanels>
                              <tabpanel>This is panel A</tabpanel>
                              <tabpanel>This is panel B</tabpanel>
                              <tabpanel>This is panel C</tabpanel>
                              <tabpanel>This is panel D</tabpanel>
                              <tabpanel>This is panel E</tabpanel>
                            </tabpanels>
                          </tabbox>
                        </tabpanel>
                        <tabpanel>
                          <tabbox orient="vertical">
                            <tabs width="20px">
                              <tab label="A"/>
                              <tab label="B"/>
                              <tab label="C"/>
                              <tab label="D"/>
                              <tab label="E"/>
                            </tabs>
                            <tabpanels>
                              <tabpanel>This is panel A</tabpanel>
                              <tabpanel>This is panel B</tabpanel>
                              <tabpanel>This is panel C</tabpanel>
                              <tabpanel>This is panel D</tabpanel>
                              <tabpanel>This is panel E</tabpanel>
                            </tabpanels>
                          </tabbox>
                        </tabpanel>
                        <tabpanel>
                          <tabbox orient="vertical">
                            <tabs width="20px">
                              <tab label="A"/>
                              <tab label="B"/>
                              <tab label="C"/>
                              <tab label="D"/>
                              <tab label="E"/>
                            </tabs>
                            <tabpanels>
                              <tabpanel>This is panel A</tabpanel>
                              <tabpanel>This is panel B</tabpanel>
                              <tabpanel>This is panel C</tabpanel>
                              <tabpanel>This is panel D</tabpanel>
                              <tabpanel>This is panel E</tabpanel>
                            </tabpanels>
                          </tabbox>
                        </tabpanel>
                        <tabpanel>
                          <tabbox orient="vertical">
                            <tabs width="20px">
                              <tab label="A"/>
                              <tab label="B"/>
                              <tab label="C"/>
                              <tab label="D"/>
                              <tab label="E"/>
                            </tabs>
                            <tabpanels>
                              <tabpanel>This is panel A</tabpanel>
                              <tabpanel>This is panel B</tabpanel>
                              <tabpanel>This is panel C</tabpanel>
                              <tabpanel>This is panel D</tabpanel>
                              <tabpanel>This is panel E</tabpanel>
                            </tabpanels>
                          </tabbox>
                        </tabpanel>
                        <tabpanel>
                          <tabbox orient="vertical">
                            <tabs width="20px">
                              <tab label="A"/>
                              <tab label="B"/>
                              <tab label="C"/>
                              <tab label="D"/>
                              <tab label="E"/>
                            </tabs>
                            <tabpanels>
                              <tabpanel>This is panel A</tabpanel>
                              <tabpanel>This is panel B</tabpanel>
                              <tabpanel>This is panel C</tabpanel>
                              <tabpanel>This is panel D</tabpanel>
                              <tabpanel>This is panel E</tabpanel>
                            </tabpanels>
                          </tabbox>
                        </tabpanel>
                        <tabpanel>
                          <tabbox orient="vertical">
                            <tabs width="20px">
                              <tab label="A"/>
                              <tab label="B"/>
                              <tab label="C"/>
                              <tab label="D"/>
                              <tab label="E"/>
                            </tabs>
                            <tabpanels>
                              <tabpanel>This is panel A</tabpanel>
                              <tabpanel>This is panel B</tabpanel>
                              <tabpanel>This is panel C</tabpanel>
                              <tabpanel>This is panel D</tabpanel>
                              <tabpanel>This is panel E</tabpanel>
                            </tabpanels>
                          </tabbox>
                        </tabpanel>
                        <tabpanel>
                          <tabbox orient="vertical">
                            <tabs width="20px">
                              <tab label="A"/>
                              <tab label="B"/>
                              <tab label="C"/>
                              <tab label="D"/>
                              <tab label="E"/>
                            </tabs>
                            <tabpanels>
                              <tabpanel>This is panel A</tabpanel>
                              <tabpanel>This is panel B</tabpanel>
                              <tabpanel>This is panel C</tabpanel>
                              <tabpanel>This is panel D</tabpanel>
                              <tabpanel>This is panel E</tabpanel>
                            </tabpanels>
                          </tabbox>
                        </tabpanel>
                        <tabpanel>
                          <tabbox orient="vertical">
                            <tabs width="20px">
                              <tab label="A"/>
                              <tab label="B"/>
                              <tab label="C"/>
                              <tab label="D"/>
                              <tab label="E"/>
                            </tabs>
                            <tabpanels>
                              <tabpanel>This is panel A</tabpanel>
                              <tabpanel>This is panel B</tabpanel>
                              <tabpanel>This is panel C</tabpanel>
                              <tabpanel>This is panel D</tabpanel>
                              <tabpanel>This is panel E</tabpanel>
                            </tabpanels>
                          </tabbox>
                        </tabpanel>
                        <!-- 			<tabpanel>This is panel 2 The second panel</tabpanel> -->
                        <!-- 			<tabpanel>This is panel 3 The second panel</tabpanel> -->
                        <!-- 			<tabpanel>This is panel 4 The second panel</tabpanel> -->
                        <!-- 			<tabpanel>This is panel 5 The second panel</tabpanel> -->
                        <!-- 			<tabpanel>This is panel 6 The second panel</tabpanel> -->
                        <!-- 			<tabpanel>This is panel 7 The second panel</tabpanel> -->
                        <!-- 			<tabpanel>This is panel 8 The second panel</tabpanel> -->
                      </tabpanels>
                    </tabbox>
                  </zk>

    runZTL(zscript,
      () => {
        waitResponse()
        val tab8 = jq(".z-tabpanel-accordion-outer:contains(Tab 8)")
        if (isFirefox) {
          click(jq("@tab:contains(Tab 8)"))
        } else {
          click(tab8)
        }
        waitResponse()
        val height8 = tab8.height()

        click(jq("@tab:contains(Tab " + 6 + ")"))
        waitResponse(true)
        click(jq("@tab:contains(Tab " + 5 + ")"))
        waitResponse(true)
        click(jq("@tab:contains(Tab " + 4 + ")"))
        waitResponse(true)
        click(jq("@tab:contains(Tab " + 3 + ")"))
        waitResponse(true)
        click(jq("@tab:contains(Tab " + 2 + ")"))
        waitResponse(true)
        click(jq("@tab:contains(Tab " + 1 + ")"))
        waitResponse(true)

        val tab1 = jq(".z-tabpanel-accordion-outer:contains(Tab 1)")
        val isHeightSame = (tab1.height() == height8)
        val isContentSame = tab1.find(".z-tabpanel-ver:contains(This is panel A)").isVisible()

        verifyTrue("The content and height of 'Tab 1' must correctly.", isHeightSame && isContentSame)
      })

  }
}