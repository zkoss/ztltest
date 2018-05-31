package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-1622.zul")
class B50_ZK_1622Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      List("listbox", "tree") foreach { compName =>
        val main = jq("@" + compName).toWidget()
        verScroll(main, 1)

        val cell = if (compName == "listbox") "listcell" else "treecell"
        click(jq(".z-" + cell + ":contains(50)"))
        waitResponse()
        click(jq("[name=" + jq(main).find(".z-paging").attr("id") + "-next]"))
        waitResponse()
        verScroll(main, 1)
        println(jq(main.$n("cave")).outerHeight()) // content height
        println(jq(main.$n("body")).scrollHeight())
        verifyTolerant(jq(main.$n("cave")).outerHeight(), jq(main.$n("body")).scrollHeight(), 2)
      }
    })

  }
}
