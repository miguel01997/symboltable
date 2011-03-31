public enum EntityKind {
	INVALID,
	METHODS,
	VARIABLES,
	CLASSES,
	LABELS;
	
	public static EntityKind getKind(String kind) {
		if (kind.equalsIgnoreCase("1")) {
			return EntityKind.METHODS;
		}
		else if (kind.equalsIgnoreCase("2")) {
			return EntityKind.VARIABLES;
		}
		else if (kind.equalsIgnoreCase("3")) {
			return EntityKind.CLASSES;
		}
		else if (kind.equalsIgnoreCase("4")) {
			return EntityKind.LABELS;
		}
		else {
			return EntityKind.INVALID;
		}
	}
	
	public static String getKindStr(EntityKind kind) {
		if (kind == EntityKind.VARIABLES) {
			return "VARIABLES";
		}
		else if (kind == EntityKind.METHODS) {
			return "METHODS";
		}
		else if (kind == EntityKind.CLASSES) {
			return "CLASSES";
		}
		else if (kind == EntityKind.LABELS) {
			return "LABELS";
		}
		else {
			return "INVALID";
		}
	}
}
