package org.regeneration.security;

public enum Role {
    DOCTOR {
        public String toString() {
            return "DOCTOR";
        }
    },
    CITIZEN {
        public String toString() {
            return "CITIZEN";
        }
    }
}
