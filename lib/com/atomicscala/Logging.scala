package com.atomicscala

/*  / sfujimoto: 2017/07/04 20:18 */
import java.util.logging._

  trait Logging {
    val log = Logger.getLogger(".")
    log.setUseParentHandlers(false)
    log.setLevel(Level.ALL)
    def addHandlers(levels:Level*) =
      for(level <- levels) {
        val fh = new FileHandler("AtomicLog-" + level.getName + ".txt")
        val ch = new ConsoleHandler
        fh.setLevel(level)
        ch.setLevel(level)
        log.addHandler(fh)
        log.addHandler(ch)
      }
    addHandlers(Level.ALL, Level.SEVERE, Level.WARNING, Level.INFO, Level.CONFIG, Level.FINE, Level.FINER)

    def error(msg:String) = log.severe(msg)
    def warn(msg:String) = log.warning(msg)
    def info(msg:String) = log.info(msg)
    def debug(msg:String) = log.fine(msg)
    def trace(msg:String) = log.finer(msg)

  }

