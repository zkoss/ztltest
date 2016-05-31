package org.zkoss.zktest.test2.F80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * Created by wenning on 5/30/16.
  */
@Tags(tags = "F80-ZK-2902.zul")
class F80_ZK_2902Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(
      () => {
        var btn = jq("@button").eq(0)
        click(btn)
        waitResponse(true)
        var li = jq(".z-listcell-content").eq(4).text()
        System.out.println(li)
        verifyEquals("item3", li)
        btn = jq("@button").eq(1)
        click(btn)
        waitResponse(true)
        li = jq(".z-listcell-content").eq(8).text()
        System.out.println(li)
        verifyEquals("item4", li)
        btn = jq("@button").eq(2)
        click(btn)
        waitResponse(true)
        li = jq(".z-listcell-content").eq(14).text()
        System.out.println(li)
        verifyEquals("item4", li)
        btn = jq("@button").eq(3)
        click(btn)
        waitResponse(true)
        li = jq(".z-listcell-content").eq(19).text()
        System.out.println(li)
        verifyEquals("item5", li)
        btn = jq("@button").eq(4)
        click(btn)
        waitResponse(true)
        li = jq(".z-listcell-content").eq(27).text()
        System.out.println(li)
        verifyEquals("item6", li)
        btn = jq("@button").eq(5)
        click(btn)
        waitResponse(true)
        li = jq(".z-listcell-content").eq(34).text()
        System.out.println(li)
        verifyEquals("item7", li)
      }
    )
  }

}
