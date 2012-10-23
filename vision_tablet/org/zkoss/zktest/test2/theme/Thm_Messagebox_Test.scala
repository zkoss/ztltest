package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Messagebox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk xmlns:w="client">
	<zscript><![CDATA[
		// Ulysses from Project Gutenberg
		String longmsg = "Stately, plump Buck Mulligan came from the stairhead,"+
		" bearing a bowl of lather on which a mirror and a razor lay crossed. "+
		"A yellow dressinggown, ungirdled, was sustained gently behind him on "+
		"the mild morning air. He held the bowl aloft and intoned:\n\n" +
		"--_Introibo ad altare Dei_.\n\n" + "Halted, he peered down the dark "+
		"winding stairs and called out coarsely:\n\n" + "--Come up, Kinch! Come"+
		" up, you fearful jesuit!\n\n Solemnly he came forward and mounted the round"+
		"gunrest. He faced about and blessed gravely thrice the tower, the "+
		"surrounding land and the awaking mountains. Then, catching sight of "+
		"Stephen Dedalus, he bent towards him and made rapid crosses in the air, "+
		"gurgling in his throat and shaking his head. Stephen Dedalus, displeased "+
		"and sleepy, leaned his arms on the top of the staircase and looked coldly "+
		"at the shaking gurgling face that blessed him, equine in its length, and "+
		"at the light untonsured hair, grained and hued like pale oak.\n\n"+
		"Buck Mulligan peeped an instant under the mirror and then covered the "+
		"bowl smartly.\n\n--Back to barracks! he said sternly.\n...\n\n"+
		"-by James Joyce, from Ulysses at Project Gutenberg";
	]]></zscript>
	<hbox>
		<window title="Messagebox" border="normal" width="300px" height="300px">
			<vbox>
				<button label="Warning" width="100px">
					<attribute name="onClick">{
							Messagebox.show("Some warning messages", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
					}</attribute>
				</button>
				<button label="Question" width="100px">
					<attribute name="onClick">{
						Messagebox.show("A question. Are you sure?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
					}</attribute>
				</button>
				<button label="Information" width="100px">
					<attribute name="onClick">{
						Messagebox.show("Some information", "Information", Messagebox.OK, Messagebox.INFORMATION);
					}</attribute>
				</button>
				<button label="Error" width="100px">
					<attribute name="onClick">{
						Messagebox.show("Some error message", "Error", Messagebox.OK, Messagebox.ERROR);
					}</attribute>
				</button>
			</vbox>
		</window>
		<separator />
		<window title="Messagebox with longer message" border="normal" width="300px" height="300px">
			<vbox>
				<button label="Warning" width="100px">
					<attribute name="onClick">{
							Messagebox.show("A warning message\nEven more warning message", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
					}</attribute>
				</button>
				<button label="Question" width="100px">
					<attribute name="onClick">{
						Messagebox.show("Is this a question?\nDoes it make sense?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
					}</attribute>
				</button>
				<button label="Information" width="100px">
					<attribute name="onClick">{
						Messagebox.show("Some information\nAnd more information", "Information", Messagebox.OK, Messagebox.INFORMATION);
					}</attribute>
				</button>
				<button label="Error" width="100px">
					<attribute name="onClick">{
						Messagebox.show("Some errors\nNo! Too many errors", "Error", Messagebox.OK, Messagebox.ERROR);
					}</attribute>
				</button>
			</vbox>
		</window>
		<separator />
		<window title="Messagebox with very long message" border="normal" width="300px" height="300px">
			<button label="Information" width="100px">
				<attribute name="onClick">{
					Messagebox.show(longmsg, "Ulysses", Messagebox.OK, Messagebox.INFORMATION);
				}</attribute>
			</button>
		</window>
		<separator />
		<window title="jq.alert()" border="normal" width="300px" height="300px">
			<button label="Alert" w:onClick="jq.alert('Test Alert')" />
		</window>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				var btns = jq("@button");
				var last = btns.length()-1
				for (i <- 0 to last) {
					singleTap(btns.eq(i));
					sleep(500);
					verifyImage();
					
					if (i != last) {
    					singleTap(jq(".z-messagebox-window .z-window-highlighted-close"));
					} else {
    					singleTap(jq(".z-window-modal .z-window-modal-close"));
					}
   					sleep(500);
				}
			});
	}
}
