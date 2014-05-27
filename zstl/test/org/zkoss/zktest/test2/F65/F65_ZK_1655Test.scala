package org.zkoss.zktest.test2.F65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.util.Scripts
import org.junit.Test
import org.zkoss.ztl.ZK

@Tags(tags = "F65-ZK-1655.zul")
class F65_ZK_1655Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	1. Mouseover on blue area, should see tooltip showed on 40px right of mouse pointer
	2. Click on pink area, should see tooltip showed on 20px down of mouse pointer
	3. RightClick on yellow area, should see tooltip showed on 50px left of mouse pointer
	</label>
	<popup id="pop">
		<label value="tooltip" />
	</popup>
	<hlayout>
		<div style="width:200px; height:200px; background:cyan;" tooltip="pop, x=(zk.currentPointer[0] + 40), y=(zk.currentPointer[1])">
			Tooltip
		</div>
		<div style="width:200px; height:200px; background:pink;" popup="pop, x=(zk.currentPointer[0]), y=(zk.currentPointer[1] + 20)">
			Popup
		</div>
		<div style="width:200px; height:200px; background:yellow;" context="pop, x=(zk.currentPointer[0] - 50), y=(zk.currentPointer[1])">
			Context
		</div>
	</hlayout>
</zk>"""
    runZTL(zscript,
      () => {

        val pxPattern = """([0-9]*)px""".r
        val parseInt = (num: String) =>
          num match {
            case pxPattern(i) => i.toInt
            case _ => 0
          }

        val cyan = jq(".z-div[style*=cyan]")
        Scripts.triggerMouseEventAt(getWebDriver(), cyan, "mouseover", "100,100")
        waitResponse()
        sleep(1000)
        val cyanPP = jq("@popup")

        // should see tooltip showed on 40px right of mouse pointer
        verifyTolerant(cyanPP.offsetTop(), cyan.offsetTop() + 100, 1)
        verifyTolerant(cyanPP.offsetLeft() - 40, cyan.offsetLeft() + 100, 1)

        val pink = jq(".z-div[style*=pink]")
        if (!ZK.is("ie") && !ZK.is("safari")) {
          clickAt(pink, "100,100")
          waitResponse()
        } else {
          click(pink)
          waitResponse()
        }
        
        val pinkPP = jq("@popup")

        // should see tooltip showed on 20px down of mouse pointer
        if (!isIE()) {
	        verifyTolerant(cyanPP.offsetTop() - 20, pink.offsetTop()+100, 3)
	        verifyTolerant(cyanPP.offsetLeft(), pink.offsetLeft()+100, 3)
        } else {
        	verifyTolerant(cyanPP.offsetTop() - 20, pink.offsetTop(), 3)
	        verifyTolerant(cyanPP.offsetLeft(), pink.offsetLeft(), 3)
        }

          
//        contextMenu cant work fine
//        val yellow = jq(".z-div[style*=yellow]")
//        Scripts.triggerMouseEventAt(getWebDriver(), yellow, "contextmenu", "100,100");
//        waitResponse()
//        sleep(1000)
//        val yellowPP = jq(".z-popup")
//        val yellowPPTop = parseInt(yellowPP.css("top"))
//        val yellowPPLeft = parseInt(yellowPP.css("left"))
//
//        print(yellowPPTop, yellow.offsetTop() + 100, yellowPPLeft + 50, yellow.offsetLeft() + 100)
//        verifyTrue("should see tooltip showed on 50px left of mouse pointer", yellowPPTop == yellow.offsetTop() + 100)
//        verifyTrue("should see tooltip showed on 50px left of mouse pointer", yellowPPLeft + 50 == yellow.offsetLeft() + 100)

      })

  }
}