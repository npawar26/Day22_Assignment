package com.bridgelabz;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	Map<String, AddressBook> map = new HashMap();

	public static void main(String[] args) {

		AddressBook addressBook1 = new AddressBook();
		Main main = new Main();

		String addressBook1Name = "AddressBook1";
		Contact contact1 = new Contact("Nikhil", "Pawar", "Dhule");
		Contact contact2 = new Contact("Aryan", "Patil", "Amalner");
		Contact contact3 = new Contact("Avi", "Patil", "Shirpur");

		addressBook1.list.add(contact1);
		addressBook1.list.add(contact2);
		addressBook1.list.add(contact3);

		main.map.put(addressBook1Name, addressBook1);

		AddressBook addressBook2 = new AddressBook();
		String addressBook2Name = "AddressBook2";
		Contact contact4 = new Contact("Ravi", "Chaudhari", "Parola");
		Contact contact5 = new Contact("Amol", "Bagul", "Dhule");
		Contact contact6 = new Contact("Abhishekh", "Patil", "Parola");
		addressBook2.list.add(contact4);
		addressBook2.list.add(contact5);
		addressBook2.list.add(contact6);
		main.map.put(addressBook2Name, addressBook2);

		List<Contact> list1 = (List<Contact>) addressBook1.list.stream().collect(Collectors.toList());
		List<Contact> list2 = (List<Contact>) addressBook2.list.stream().collect(Collectors.toList());
		list1.addAll(list2);
		Map<String, List<Contact>> map = list1.stream().collect(Collectors.groupingBy(Contact::getCity));
		System.out.println("Contacts by cityName" + map);

		System.out.println("Count of contacts by cityName");
		Map<String, Long> counting = list1.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		counting.forEach((city, count) -> System.out.println(city + "->" + count));
	}
}
