package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-945.zul")
class B60_ZK_945Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<div>Open the combobox, you chould see 4 comboitems in it.</div>
	<div>You can find the space between image and label in 1st and 4th comboitem is smaller.</div>
	<div>You can find the space between image and label in 2nd and 3rd comboitem is larger.</div>
	<style>
		.specific-item .z-comboitem-spacer {
			margin-right: 30px;
		}
	</style>
    <combobox>
    	<comboitem image="/img/battery.gif" label="test" />
    	<comboitem image="/img/battery.gif" label="test 2" sclass="specific-item"
    		description="description description" />
    	<comboitem image="/img/battery.gif" label="test 3" sclass="specific-item"
    		content="content content" />
    	<comboitem image="/img/battery.gif" label="test 4"
    		description="description description" content="content content" />
    </combobox>
</zk>"""

    runZTL(zscript,
      () => {
        click(jq(jq(".z-combobox").toWidget().$n("btn")))
        waitResponse()

        val spacer0Right = jq(".z-comboitem-spacer:eq(0)").css("margin-right")
        val spacer1Right = jq(".z-comboitem-spacer:eq(1)").css("margin-right")
        val spacer2Right = jq(".z-comboitem-spacer:eq(2)").css("margin-right")
        val spacer3Right = jq(".z-comboitem-spacer:eq(3)").css("margin-right")
        verifyEquals(spacer0Right, spacer3Right)
        verifyEquals(spacer1Right, spacer2Right)
        
        val Pattern = """(\d*)px""".r
        val parseInt = (text:String) => text match {
          case Pattern(i) => i.toInt
          case _ => 0
        }
        
        val msg = "You can find the space between image and label in 1st and 4th comboitem is smaller. \n" +
          "  You can find the space between image and label in 2nd and 3rd comboitem is larger."
        verifyTrue(msg, parseInt(spacer0Right) < parseInt(spacer1Right))

      })

  }
}
