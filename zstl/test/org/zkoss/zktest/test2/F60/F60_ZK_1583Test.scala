package org.zkoss.zktest.test2.F60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F60-ZK-1583.zul")
class F60_ZK_1583Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<zscript><![CDATA[
		String[] pos = { "before_start", "before_center", "before_end", 
				"after_start", "after_center", "after_end", "start_before", 
				"start_center", "start_after", "end_before", "end_center", 
				"end_after" };
		ListModelList model = new ListModelList(pos);
	]]></zscript>
	<style>
	.z-notification-ref .z-notification-cl {
		width: 300px;
	}
	</style>
	<vlayout vflex="1">
		<label multiline="true">
			1. Select notification position then click "show info" button.
			2. Should see the ARROW of notification point to center of GREEN component.
			3. Check "show warning" button with YELLOW component.
			4. Check "show error" button with RED component.
		</label>
		<hlayout vflex="1">
			<selectbox id="position" model="${model}" selectedIndex="0" />
			<button label="show info">
				<attribute name="onClick">
					int i = Math.max(0, position.getSelectedIndex());
					String p = pos[i];
					Clients.showNotification("Info Message", Clients.NOTIFICATION_TYPE_INFO, info, p, -1);
				</attribute>
			</button>
			<button label="show warning">
				<attribute name="onClick">
					int i = Math.max(0, position.getSelectedIndex());
					String p = pos[i];
					Clients.showNotification("Warning Message", Clients.NOTIFICATION_TYPE_WARNING, warn, p, -1);
				</attribute>
			</button>
			<button label="show error">
				<attribute name="onClick">
					int i = Math.max(0, position.getSelectedIndex());
					String p = pos[i];
					Clients.showNotification("Error Message", Clients.NOTIFICATION_TYPE_ERROR, error, p, -1);
				</attribute>
			</button>
		</hlayout>
		<hlayout spacing="3px" height="30px">
			<div hflex="1"></div>
			<div id="info" width="25px" height="25px" style="background: green" />
			<div id="warn" width="25px" height="25px" style="background: yellow" />
			<div id="error" width="25px" height="25px" style="background: red" />
		</hlayout>
	</vlayout>
</zk>"""
    runZTL(zscript,
      () => {
        List("before_start", "before_center", "before_end",
          "after_start", "after_center", "after_end", "start_before",
          "start_center", "start_after", "end_before", "end_center",
          "end_after") foreach { pos =>
            select(jq(".z-selectbox"), pos);
            waitResponse()
            Map("info" -> "green", "warning" -> "yellow", "error" -> "red") foreach {
              case (notifyType, color) =>
                click(jq(".z-button:contains(" + notifyType + ")"))
                waitResponse()
                sleep(1000)
                val div = jq("div[style*=" + color + "]")
                val pointer = jq(".z-notification-pointer")
                val divLeftMid = div.offsetLeft() + 0.5 * div.width()
                val pointerLeftMid = pointer.offsetLeft() + 0.5 * pointer.width()
                val divTopMid = div.offsetTop() + 0.5 * div.height()
                val pointerTopMid = pointer.offsetTop() + 0.5 * pointer.height()
                if (pos.startsWith("b") || pos.startsWith("a")) {
                  verifyTrue("Should see the ARROW of notification point to center", (divLeftMid - pointerLeftMid).abs < 11)
                } else {
                  verifyTrue("Should see the ARROW of notification point to center", (divTopMid - pointerTopMid).abs < 11)
                }
                click(jq(".z-selectbox"))
                waitResponse()
            }
          }
      })

  }
}