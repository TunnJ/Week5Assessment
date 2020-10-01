

import java.util.List;
import java.util.Scanner;

import controller.ListPlayerHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListPlayerHelper lih = new ListPlayerHelper();

		private static void addAPlayer() {
			// TODO Auto-generated method stub
			System.out.print("Enter a team: ");
			String team = in.nextLine();
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			ListItem toAdd = new ListItem(team, name);
			lih.insertPlayer(toAdd);
		}

		private static void deleteAPlayer() {
			// TODO Auto-generated method stub
			System.out.print("Enter the team to delete: ");
			String team = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			ListItem toDelete = new ListItem(team, name);
			lih.deletePlayer(toDelete);
		}

		private static void editAPlayer() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Team");
			System.out.println("2 : Search by Name");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the team name: ");
				String teamName = in.nextLine();
				foundItems = lih.searchForPlayerByTeam(teamName);
			} else {
				System.out.print("Enter the name: ");
				String name = in.nextLine();
				foundItems = lih.searchForPlayerByName(name);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForPlayerById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getTeam());
				System.out.println("1 : Update Team");
				System.out.println("2 : Update Name");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Team: ");
					String newTeam = in.nextLine();
					toEdit.setTeam(newTeam);
				} else if (update == 2) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				}

				lih.updatePlayer(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome roster! ---");
			while (goAgain) {
				System.out.println("*  Select a player:");
				System.out.println("*  1 -- Add a player");
				System.out.println("*  2 -- Edit a player");
				System.out.println("*  3 -- Delete a player");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAPlayer();
				} else if (selection == 2) {
					editAPlayer();
				} else if (selection == 3) {
					deleteAPlayer();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListItem> allPlayers = lih.showAllPlayers();
			for(ListItem singleItem : allPlayers) {
				System.out.println(singleItem.returnPlayerDetails());
			}
		}

	}