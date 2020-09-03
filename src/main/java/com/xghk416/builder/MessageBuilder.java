package com.xghk416.builder;

import java.util.ArrayList;

public class MessageBuilder {

        private ArrayList<Object> components = new ArrayList();

        public MessageBuilder() {
        }

        public MessageBuilder add(Object object) {
            this.components.add(object);
            return this;
        }

        public MessageBuilder newLine() {
            return this.add((Object)"\n");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            this.components.forEach(stringBuilder::append);
            return stringBuilder.toString();
        }
        public ArrayList<Object> getComponents() {
            return this.components;
        }

}
