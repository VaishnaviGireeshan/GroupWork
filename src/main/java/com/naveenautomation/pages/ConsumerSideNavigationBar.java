package com.naveenautomation.pages;

public enum ConsumerSideNavigationBar {
	MY_ACCOUNT("My Account",AccountPage.class),
    EDIT_ACCOUNT("Edit Account",EditAccountPage.class),
    PASSWORD("Password",ChangePasswordPage.class),
    ADDRESS_BOOK("Address Book",AddressBookPage.class),
    WISH_LIST("Wish List",WishListPage.class),
    ORDER_HISTORY("Order Histroy",OrderHistroyPage.class),
    DOWNLODS("Downloads",DownloadsPage.class),
    RECURRING_PAYMENTS("Recurring payments",RecurringPaymentsPage.class),
    REWARD_POINTS("Reward Points",RewardPointsPage.class),
    RETURNS("Returns",ReturnsPage.class),
    TRANSACTIONS("Transactions",TransactionsPage.class),
    NEWSLETTER("Newsletter",NewsLetterSubscriptionPage.class),
    LOGOUT("Logout",LogoutPage.class);
	
	
	private Class<? extends Page> _pageClass;
	private String item;

	ConsumerSideNavigationBar(String item,Class<? extends Page> pageClass) {
		this._pageClass = pageClass;
		this.item=item;
	}

	public Class<? extends Page> getpageClass() {
		return _pageClass;
	}
	
	

	public String getItem() {
		return item;
	}

	public static ConsumerSideNavigationBar getItemByText(String text) {
		ConsumerSideNavigationBar[] all = ConsumerSideNavigationBar.values();
		for (int i = 0; i < all.length; i++) {
			if (all[i].name().toLowerCase().equalsIgnoreCase(text)) {//name() Returns the name of this enum constant,
				return all[i];
			}
		}
		return null;
	}

	
}
