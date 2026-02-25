import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F51-ZK-264TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F51-ZK-264TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vlayout>
			Click the following button, then check if six lines of Priorities will be shown as the following sequence:
			"Highest", "ZUML", "High", "Normal", "Normal", "Low"
			<button id="b" label="test"
			 onClick=\'self.parent.appendChild(new Label("ZUML Priority"))\'/>
			<zscript>
			//org.zkoss.lang.Library.setProperty("org.zkoss.zk.ui.EventListener.duplicateIgnored", "true");
			EventListener li;
			b.addEventListener("onClick", li = new EventListener() {
				public void onEvent(Event event) {
					b.parent.appendChild(new Label("Normal Priority"));
				}
			});
			b.addEventListener(-1, "onClick", new EventListener() {
				public void onEvent(Event event) {
					b.parent.appendChild(new Label("Low Priority"));
				}
			});
			b.addEventListener(1, "onClick", new EventListener() {
				public void onEvent(Event event) {
					b.parent.appendChild(new Label("High Priority"));
				}
			});
			b.addEventListener("onClick", li);
			b.addEventListener(1000, "onClick", new EventListener() {
				public void onEvent(Event event) {
					b.parent.appendChild(new Label("Highest Priority"));
				}
			});
			</zscript>
			</vlayout>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("b", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-label:contains(Highest Priority)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq(".z-label:contains(ZUML Priority)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0 && verifyVariable_cafe_1_1)
		.ok("The labels should exist.");
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-label:contains(Highest Priority)").offset().top,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(".z-label:contains(ZUML Priority)").offset().top,
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => jq(".z-label:contains(Highest Priority)").offset().top,
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq(".z-label:contains(ZUML Priority)").offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_4_4 < verifyVariable_cafe_5_5)
		.ok("Highest Priority should before ZUML Priority");
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => !!jq(".z-label:contains(ZUML Priority)")[0],
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() => !!jq(".z-label:contains(High Priority)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0t && verifyVariable_cafe_1_1t)
		.ok("The labels should exist.");
	let verifyVariable_cafe_2_2t = await ClientFunction(
		() => jq(".z-label:contains(ZUML Priority)").offset().top,
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(
		() => jq(".z-label:contains(High Priority)").offset().top,
	)();
	let verifyVariable_cafe_4_4t = await ClientFunction(
		() => jq(".z-label:contains(ZUML Priority)").offset().top,
	)();
	let verifyVariable_cafe_5_5t = await ClientFunction(
		() => jq(".z-label:contains(High Priority)").offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_4_4t < verifyVariable_cafe_5_5t)
		.ok("ZUML Priority should before High Priority");
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => !!jq(".z-label:contains(High Priority)")[0],
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() => !!jq(".z-label:contains(Normal Priority)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0tt && verifyVariable_cafe_1_1tt)
		.ok("The labels should exist.");
	let verifyVariable_cafe_2_2tt = await ClientFunction(
		() => jq(".z-label:contains(High Priority)").offset().top,
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(
		() => jq(".z-label:contains(Normal Priority)").offset().top,
	)();
	let verifyVariable_cafe_4_4tt = await ClientFunction(
		() => jq(".z-label:contains(High Priority)").offset().top,
	)();
	let verifyVariable_cafe_5_5tt = await ClientFunction(
		() => jq(".z-label:contains(Normal Priority)").offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_4_4tt < verifyVariable_cafe_5_5tt)
		.ok("High Priority should before Normal Priority");
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => !!jq(".z-label:contains(Normal Priority)")[0],
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() => !!jq(jq(".z-label:contains(Normal Priority)")[1])[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttt && verifyVariable_cafe_1_1ttt)
		.ok("The labels should exist.");
	let verifyVariable_cafe_2_2ttt = await ClientFunction(
		() => jq(".z-label:contains(Normal Priority)").offset().top,
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(
		() => jq(jq(".z-label:contains(Normal Priority)")[1]).offset().top,
	)();
	let verifyVariable_cafe_4_4ttt = await ClientFunction(
		() => jq(".z-label:contains(Normal Priority)").offset().top,
	)();
	let verifyVariable_cafe_5_5ttt = await ClientFunction(
		() => jq(jq(".z-label:contains(Normal Priority)")[1]).offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_4_4ttt < verifyVariable_cafe_5_5ttt)
		.ok("Normal Priority should before Normal Priority");
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() => !!jq(".z-label:contains(Normal Priority)")[0],
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(
		() => !!jq(".z-label:contains(Low Priority)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttt && verifyVariable_cafe_1_1tttt)
		.ok("The labels should exist.");
	let verifyVariable_cafe_2_2tttt = await ClientFunction(
		() => jq(".z-label:contains(Normal Priority)").offset().top,
	)();
	let verifyVariable_cafe_3_3tttt = await ClientFunction(
		() => jq(".z-label:contains(Low Priority)").offset().top,
	)();
	let verifyVariable_cafe_4_4tttt = await ClientFunction(
		() => jq(".z-label:contains(Normal Priority)").offset().top,
	)();
	let verifyVariable_cafe_5_5tttt = await ClientFunction(
		() => jq(".z-label:contains(Low Priority)").offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_4_4tttt < verifyVariable_cafe_5_5tttt)
		.ok("Normal Priority should before Low Priority");
});
