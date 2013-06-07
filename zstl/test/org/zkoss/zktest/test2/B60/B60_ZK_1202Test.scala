package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1202.zul")
class B60_ZK_1202Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
                  <zk>
                    <html>
                      <![CDATA[
  <ol>
  <li>You shall see two comboboxes.</li> 
  <li>The first combobox contains the week type: "Regular Week" and "Working Week".</li>
  <li>The second combobox contains the days indicated by the selection of the first combobox.</li>
  <li>If "Regular Week" is selected in the first combobox, the second combobox should contain "Sunday" through "Saturday".</li>
  <li>If "Working Week" is selected in the first combobox, the second combobox should contain "Monday" through "Friday".</li>
  <li>No exceptions should occur when changing the selection in any order.</li>
  </p>
]]>
                    </html>
                    <borderlayout width="100%" height="100%" apply="org.zkoss.bind.BindComposer" viewModel="@id('dw') 
    @init('org.zkoss.zktest.test2.B60_ZK_1202_DaysAndWeeks')">
                      <center>
                        <grid model="@load(dw.dayWeekModels)" width="550px" emptyMessage="No Index Fields to show">
                          <columns>
                            <column label="Week Type"/>
                            <column label="Days"/>
                          </columns>
                          <rows>
                            <template name="model" var="dayWeekModel">
                              <row>
                                <combobox autocomplete="true" readonly="true" autodrop="true" selectedItem="@bind(dayWeekModel.selectedWeekType)" model="@bind(dayWeekModel.weekTypes)">
                                  <template name="model" var="weekType">
                                    <comboitem label="@load(weekType)"/>
                                  </template>
                                </combobox>
                                <combobox autocomplete="true" readonly="true" model="@bind(dayWeekModel.days)" selectedItem="@load(dayWeekModel.selectedDay)">
                                  <template name="model" var="day">
                                    <comboitem label="@load(day)"/>
                                  </template>
                                </combobox>
                              </row>
                            </template>
                          </rows>
                        </grid>
                      </center>
                    </borderlayout>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals("You shall see two comboboxes.", jq(".z-combobox").length(), 2)

        val btn1 = jq(".z-combobox-icon:eq(0)")
        val regular = jq(".z-comboitem:contains(Regular)")
        val working = jq(".z-comboitem:contains(Working)")
        val btn2 = jq(".z-combobox-icon:eq(1)")

        val regularDays = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        val workingDays = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

        click(btn1)
        waitResponse()

        verifyTrue("The first combobox contains the week type: 'Regular Week' and 'Working Week'.", regular.exists())
        verifyTrue("The first combobox contains the week type: 'Regular Week' and 'Working Week'.", working.exists())

        click(regular)
        waitResponse()
        verifyTrue("No exceptions should occur when changing the selection in any order.", !jq(".z-window-modal").exists())

        val verifyDayOk = (msg: String, days: List[String]) =>
          days foreach { day =>
            click(btn2)
            waitResponse()
            val dayItem = jq(".z-combobox-popup .z-comboitem:contains(" + day + ")")
            verifyNotEquals(msg, dayItem.css("display"), "none")
            click(dayItem)
            waitResponse()
            verifyTrue("No exceptions should occur when changing the selection in any order.", !jq(".z-window-modal").exists())
          }

        verifyDayOk("If 'Regular Week' is selected in the first combobox, the second combobox should contain 'Sunday' through 'Saturday'.", regularDays)

        click(btn1)
        waitResponse()

        click(working)
        waitResponse()
        verifyTrue("No exceptions should occur when changing the selection in any order.", !jq(".z-window-modal").exists())

        verifyDayOk("If 'Working Week' is selected in the first combobox, the second combobox should contain 'Monday' through 'Friday'.", workingDays)

      })

  }
}
