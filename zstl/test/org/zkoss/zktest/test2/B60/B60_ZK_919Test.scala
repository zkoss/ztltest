package org.zkoss.zktest.test2.B60

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
        val datelongfmt0 = jq(jq(".z-datebox:eq(0)").toWidget().$n("real")).`val`()
        val datelongfmt1 = jq(jq(".z-datebox:eq(1)").toWidget().$n("real")).`val`()
        val datelongfmt2 = jq(jq(".z-datebox:eq(2)").toWidget().$n("real")).`val`()
        val datelongfmt3 = jq(jq(".z-datebox:eq(3)").toWidget().$n("real")).`val`()
        val msg1 = "1. You shall see 4 type of dates whose time part are the same. "

        val Pattern1 = """.*(\d\d):(\d\d):(\d\d).*""".r
        val Pattern2 = """.*( \d):(\d\d):(\d\d).*""".r

        val long2short = (shtfmt: String) => shtfmt match {
          case Pattern1(hh, mm, ss) => hh + ":" + mm + ":" + ss
          case Pattern2(h, mm, ss) => h.replace(" ", "0").concat(":").concat(mm).concat(":").concat(ss)
          case _ => "00:00:00"
        }
        
        val date0 = long2short(datelongfmt0)
        val date1 = long2short(datelongfmt1)
        val date2 = long2short(datelongfmt2)
        val date3 = long2short(datelongfmt3)

        verifyEquals(msg1, date0, date1)
        verifyEquals(msg1, date2, date3)
        verifyEquals(msg1, date0, date2)

        0 to 3 foreach { i =>
          click(jq(".z-datebox:eq(" + i + ")").toWidget().$n("btn"))
          waitResponse()
          click(jq(".z-calendar:eq(" + i + ") .z-calendar-weekday:contains(14)"))
          waitResponse()
        }

        verifyTrue("should not see any error message.", !jq(".z-errorbox").exists())
      })

  }
}
