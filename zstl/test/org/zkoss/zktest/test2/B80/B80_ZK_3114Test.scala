package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * Created by wenning on 5/30/16.
  */
@Tags(tags = "B80-ZK-3114.zul")
class B80_ZK_3114Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        var chosenbox = jq("@chosenbox").get(0)
        //dropdown chosenbox options
        click(chosenbox)
        waitResponse(true)
        //chose "DD"
        var chboption = jq(".z-chosenbox-option:visible").get(3)
        click(chboption)
        waitResponse(true)
        //dropdown chosenbox options
        click(chosenbox)
        waitResponse(true)
        //chose "BB"
        chboption = jq(".z-chosenbox-option:visible").get(1)
        click(chboption)
        waitResponse(true)
        //dropdown chosenbox options
        click(chosenbox)
        waitResponse(true)
        //chose "EE"
        chboption = jq(".z-chosenbox-option:visible").get(2)
        click(chboption)
        waitResponse(true)
        //should exist 3 selected options "DD" "BB" "EE"
        var chbitem = jq(".z-chosenbox > .z-chosenbox-item").length()
        System.out.println(chbitem)
        verifyEquals(3, chbitem)
        //click "replace" button
        var btn = jq("@button").get(0)
        click(btn)
        waitResponse(true)
        //shouldn't have any selected options
        chbitem = jq(".z-chosenbox > .z-chosenbox-item").length()
        System.out.println(chbitem)
        verifyEquals(0, chbitem)
      }
    )
  }
}
