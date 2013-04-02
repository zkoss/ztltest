package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Notification_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk xmlns:n="native">
	<zscript><![CDATA[
		import org.zkoss.zk.ui.util.*;
		import org.zkoss.zul.*;

		ListModel posm1 = new SimpleListModel(new String[] {
			"(default)", "before_start", "before_center", "before_end", 
			"after_start", "after_center", "after_end", "start_before", 
			"start_center", "start_after", "end_before", "end_center", 
			"end_after", "top_left", "top_center", "top_right", "middle_center",
			"middle_left", "middle_right", "bottom_left", "bottom_center", 
			"bottom_right"
		});
		ListModel posm2 = new SimpleListModel(new String[] {
			"(default)", "top_left", "top_center", "top_right", "middle_center",
			"middle_left", "middle_right", "bottom_left", "bottom_center", 
			"bottom_right", "at_pointer", "after_pointer", "200, 200"
		});
		ListModel types = new SimpleListModel(new String[] {
			Clients.NOTIFICATION_TYPE_INFO,
			Clients.NOTIFICATION_TYPE_WARNING,
			Clients.NOTIFICATION_TYPE_ERROR
		});
		String[] msgs = new String[] {
			"En taro adun.",
			"Use the force, Harry.",
			"I don't always drink beer, but when I do, I code a lot.",
			"Also possible to do <span style=\"font-weight: bold\">HTML</span>."
		};
	]]></zscript>
	<div style="padding: 5px; border: 1px solid #339999">
		<n:table>
			<n:tr>
				<n:td rowspan="2">
					<button label="Show">
						<attribute name="onClick"><![CDATA[
							int dur = adcb.checked ? adms.value : -1;
							Component ref = refcb.checked ? win : null;
							ListModel model = refcb.checked ? posm1 : posm2;
							int i = Math.max(0, posbox.selectedIndex);
							String plb = (String) model.getElementAt(i);
							String pval = plb.charAt(0) == '(' ? null : plb;
							i = Math.max(0, typebox.selectedIndex);
							String type = (String) types.getElementAt(i);
							String msg = msgbox.selectedItem.value;
							if (msg == null)
								msg = msgs[(int) (Math.random() * msgs.length)];
							if (pval != null && pval.contains(",")) {
								String[] ss = pval.split(",", 2);
								int x = Integer.parseInt(ss[0].trim());
								int y = Integer.parseInt(ss[1].trim());
								Clients.showNotification(msg, type, ref, x, y, dur, closable.checked);
							} else
								Clients.showNotification(msg, type, ref, pval, dur, closable.checked);
						]]></attribute>
					</button>
				</n:td>
				<n:td>
					<label>Reference</label>
				</n:td>
				<n:td>
					<label>Position</label>
				</n:td>
				<n:td>
					<label>Type</label>
				</n:td>
				<n:td>
					<label>Duration (ms)</label>
				</n:td>
				<n:td>
					<label>Message</label>
				</n:td>
				<n:td>
					<label>Closable</label>
				</n:td>
			</n:tr>
			<n:tr>
				<n:td>
					<checkbox id="refcb" label="Window" checked="true" 
						onCheck='posbox.model = self.checked ? posm1 : posm2' />
				</n:td>
				<n:td>
					<selectbox id="posbox" model="${posm1}" />
				</n:td>
				<n:td>
					<selectbox id="typebox" model="${types}" />
				</n:td>
				<n:td>
					<checkbox id="adcb" />
					<intbox id="adms" value="2000" />
				</n:td>
				<n:td>
					<listbox id="msgbox" mold="select">
						<listitem label="(random)" selected="true" />
						<listitem label="Protoss" value="${msgs[0]}" />
						<listitem label="Force" value="${msgs[1]}" />
						<listitem label="Beer" value="${msgs[2]}" />
						<listitem label="HTML" value="${msgs[3]}" />
					</listbox>
				</n:td>
				<n:td>
					<checkbox id="closable" checked="true" />
				</n:td>
			</n:tr>
		</n:table>
	</div>
	<div style="padding: 150px 250px">
		<window id="win" border="normal" title="Window" height="300px" width="300px">
			Window Content
		</window>
	</div>
</zk>""";

		runZTL(zscript,
			() => {
				var btn_show     = jq("@button[label=Show]");		// Show button
				var chk_window   = jq("@checkbox:eq(0)");			// Position relative to window?
				var sel_position = jq("@selectbox:eq(0)");			// Position to show notification
				var sel_type     = jq("@selectbox:eq(1)");			// Type of notification
				var sel_message  = jq("@select:eq(0)");				// Notification message
				var chk_closable = jq("@checkbox:eq(2)");			// Notification Closable
				
				// Fix message for vision test
				select(sel_message, 2);
				sleep(500);
				verifyImage();
				
				// Notification positioned relative to the window
				
				// Type: info
				for (i <- 0 to 21) {
					select(sel_position, i);
					singleTap(btn_show);
					sleep(500);
					verifyImage();
				
					singleTap(jq(".z-notification-close"));
					sleep(500);
				}
				
				// Type: warning
				select(sel_type, 1);
				for (i <- 0 to 21) {
					select(sel_position, i);
					singleTap(btn_show);
					sleep(500);
					verifyImage();
				
					singleTap(jq(".z-notification-close"));
					sleep(500);
				}
				
				// Type: error
				select(sel_type, 2);
				for (i <- 0 to 21) {
					select(sel_position, i);
					singleTap(btn_show);
					sleep(500);
					verifyImage();
				
					singleTap(jq(".z-notification-close"));
					sleep(500);
				}
			});
	}
}