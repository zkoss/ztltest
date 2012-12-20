package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-919.zul")
class B60_ZK_919Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
    				<window width="400px" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.test2.B60_ZK_919_ViewModel')">
                    <label pre="true">
                      1. You shall see 4 type of dates whose time part are the same. 
2. Change the date of each datebox.
3. If no exception, then it is OK.
                    </label>
                    <grid>
                      <columns>
                        <column hflex="min"></column>
                        <column></column>
                      </columns>
                      <rows>
                        <row>java.util.Date: <datebox value="@bind(vm.utildate)" format="medium+medium" hflex="true"/></row>
                        <row>java.sql.Date: <datebox value="@bind(vm.sqldate)" format="medium+medium" hflex="true"/></row>
                        <row>java.sql.Time:<datebox value="@bind(vm.sqltime)" format="medium+medium" hflex="true"/></row>
                        <row>java.sql.Timestamp<datebox value="@bind(vm.sqltimestamp)" format="medium+medium" hflex="true"/></row>
                      </rows>
                    </grid>
                  </window>
    			  </zk>"""

    runZTL(zscript,
      () => {
        val date0 = jq(".z-datebox-inp:eq(0)").`val`().substring(12)
        val date1 = jq(".z-datebox-inp:eq(1)").`val`().substring(12)
        val date2 = jq(".z-datebox-inp:eq(2)").`val`().substring(12)
        val date3 = jq(".z-datebox-inp:eq(3)").`val`().substring(12)
        val msg1 = "1. You shall see 4 type of dates whose time part are the same. "
        verifyEquals(msg1, date0, date1)
        verifyEquals(msg1, date2, date3)
        verifyEquals(msg1, date0, date2)

        0 to 3 foreach { i =>
          click(jq(".z-datebox-btn:eq(" + i + ")"))
          waitResponse()
          click(jq(".z-calendar:eq(" + i + ") .z-calendar-caldayrow:eq(2)").find(".z-calendar-wkday:eq(2)"))
          waitResponse()
        }

        verifyTrue("should not see any error message.", !jq(".z-errbox").exists())
      })

  }
}
