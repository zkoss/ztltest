import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3284144TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3284144TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<h:pre xmlns:h="xhtml" >
	
		Click each datebox\'s button , and check if the timebox shows like the format.
		
		The timebox means the textbox below the Calendar , 
		check the value in timebox.
		
					
	</h:pre>
	
	<zscript>
		import java.util.Date;
		
		Date d = new Date(110,3,27,18,20,30);
	</zscript>
	<grid>
		<rows>
			<row>
				<label value="yyyy-MM-dd ss => should show 30 " />
				<datebox format="yyyy-MM-dd ss" value="\${d}" width="300px" />
			</row>
			
			<row>
				<label value="yyyy-MM-dd hh:mm:ss => should show 06:20:30 " />
				<datebox format="yyyy-MM-dd hh:mm:ss" value="\${d}" width="300px" />
			</row>
	
			<row>
				<label value="yyyy-MM-dd KK:mm:ss => should show 06:20:30 " />
				<datebox format="yyyy-MM-dd KK:mm:ss" value="\${d}" width="300px" />
			</row>
			
			<row>
				<label value="yyyy-MM-dd hh:mm:ss aa  => should show 06:20:30 PM" />
				<datebox format="yyyy-MM-dd hh:mm:ss aa" value="\${d}" width="300px" />
			</row>
			<row>
				<label value="yyyy-MM-dd aa hh:mm:ss  => should show PM 06:20:30 " />
				<datebox format="yyyy-MM-dd aa hh:mm:ss" value="\${d}" width="300px" />
			</row>
			
			<row>
				<label value="yyyy-MM-dd KK:mm:ss => should show 06:20:30 " />
				<datebox format="yyyy-MM-dd KK:mm:ss " value="\${d}" width="300px" />
			</row>
	
			<row>
				<label value="yyyy-MM-dd HH:mm:ss => should show 18:20:30 " />
				<datebox format="yyyy-MM-dd HH:mm:ss" value="\${d}" width="300px" />
			</row>		
	
			<row>
				<label value="yyyy-MM-dd kk:mm:ss => should show 18:20:30 " />
				<datebox format="yyyy-MM-dd kk:mm:ss" value="\${d}" width="300px" />
			</row>		
		
		</rows>
	</grid>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("@datebox:eq(0)")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox:visible")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("30"));
	await t
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(0)")).$n("btn")))
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(1)")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox:visible")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("06:20:30"));
	await t
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(1)")).$n("btn")))
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(2)")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox:visible")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("06:20:30"));
	await t
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(2)")).$n("btn")))
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(3)")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox:visible")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("06:20:30 PM"));
	await t
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(3)")).$n("btn")))
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(4)")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox:visible")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("PM 06:20:30"));
	await t
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(4)")).$n("btn")))
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(5)")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox:visible")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("06:20:30"));
	await t
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(5)")).$n("btn")))
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(6)")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox:visible")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("18:20:30"));
	await t
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(6)")).$n("btn")))
		.click(Selector(() => zk.Widget.$(jq("@datebox:eq(7)")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@timebox:visible")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("18:20:30"));
	await t.click(Selector(() => zk.Widget.$(jq("@datebox:eq(7)")).$n("btn")));
});
