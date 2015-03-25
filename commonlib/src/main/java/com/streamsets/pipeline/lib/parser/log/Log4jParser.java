/**
 * (c) 2014 StreamSets, Inc. All rights reserved. May not
 * be copied, modified, or distributed in whole or part without
 * written consent of StreamSets, Inc.
 */
package com.streamsets.pipeline.lib.parser.log;

/**
 * (c) 2014 StreamSets, Inc. All rights reserved. May not
 * be copied, modified, or distributed in whole or part without
 * written consent of StreamSets, Inc.
 */
import com.google.common.collect.ImmutableList;
import com.streamsets.pipeline.api.Stage;
import com.streamsets.pipeline.lib.io.OverrunReader;
import com.streamsets.pipeline.lib.parser.DataParserException;
import java.io.IOException;

public class Log4jParser extends GrokParser {

  public Log4jParser(Stage.Context context, String readerId, OverrunReader reader, long readerOffset,
                                 int maxObjectLen, boolean retainOriginalText, String log4jFormat,
                                 int maxStackTraceLines)
    throws IOException, DataParserException {
    super(context, readerId, reader, readerOffset, maxObjectLen, retainOriginalText, "",
      log4jFormat, ImmutableList.of(Constants.GROK_LOG4J_LOG_PATTERNS_FILE_NAME), maxStackTraceLines);
  }

  @Override
  protected void handleNoMatch(String logLine) throws DataParserException {
    throw new DataParserException(Errors.LOG_PARSER_03, logLine, "Log4j Log Format");
  }

}