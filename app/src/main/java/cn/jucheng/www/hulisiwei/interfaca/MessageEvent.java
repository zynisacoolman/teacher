package cn.jucheng.www.hulisiwei.interfaca;

/**
 * Created by w on 2017-11-29.
 * 消息事件类
 */


    public class MessageEvent {

        private String message;//信息
        int isMessage = 0;//信息分类，1是表单头部信息，2是清空所有信息，3是签字信息,4是表单信息,5转抄医嘱

        /**
         *
         * @param message 信息
         */
        public MessageEvent(String message,int isMessage) {
            this.message = message;
            this.isMessage = isMessage;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getIsMessage() {
            return isMessage;
        }

        public void setIsMessage(int isMessage) {
            this.isMessage = isMessage;
        }
    }

